//
//  LaunchesScreen.swift
//  iosApp
//
//  Created by ahmed elbagory on 09/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct LaunchesScreen: View {
    
    @StateObject var viewModel = LaunchesViewModel()
    
    
    var body: some View {
        if viewModel.state.isLoading {
            LoadingIndicator()
        } else if !viewModel.state.error.isEmpty {
            ErrorHolder(error:viewModel.state.error)
        } else {
                
                List {
                    ForEach(viewModel.state.launches, id: \.self) { launch in
                        RocketLaunchRow(rocketLaunch: launch)
                    }
                } 
                .navigationBarTitle("Launches")

        }
        
    }
}
