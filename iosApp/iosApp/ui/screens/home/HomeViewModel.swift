//
//  HomeViewModel.swift
//  iosApp
//
//  Created by ahmed elbagory on 10/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

class HomeViewModel: ObservableObject {
    private var homeUseCase = DIHelper().homeUseCase
    
    @Published private var homeState = HomeState()
    var state: HomeState {
            return homeState
        }


    init() {

     self.getHome()
                
    }
    
    func getHome() {
       
        self.homeState.homeList = self.homeUseCase.invoke()
    }

    }

