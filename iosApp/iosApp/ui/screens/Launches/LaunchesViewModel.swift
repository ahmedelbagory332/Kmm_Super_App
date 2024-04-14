//
//  LaunchesState.swift
//  iosApp
//
//  Created by ahmed elbagory on 09/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

class LaunchesViewModel: ObservableObject {
    private var launchesUseCase = DIHelper().launchesUseCase
    
    @Published private var launchesState = LaunchesState()
    var state: LaunchesState {
            return launchesState
        }
    private var resultList: [RocketLaunch] = []


    init() {

     self.getLaunches()
                
    }
    
    func getLaunches() {
        self.launchesState.isLoading = true
        DispatchQueue.main.async {
            Task {
                do {
                    self.resultList = try await self.launchesUseCase.invoke()
                    DispatchQueue.main.async {
                        self.launchesState.isLoading = false
                        self.launchesState.launches = self.resultList
                    }
                } catch {
                    DispatchQueue.main.async {
                        self.launchesState.isLoading = false
                               if !self.resultList.isEmpty {
                                   self.launchesState.launches = self.resultList
                               } else {
                                   self.launchesState.error = error.localizedDescription
                               }
                           }
                }
            }
        }
    }

    }
