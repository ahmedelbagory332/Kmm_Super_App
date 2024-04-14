//
//  LaunchesState.swift
//  iosApp
//
//  Created by ahmed elbagory on 09/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

struct LaunchesState: Equatable {
    var isLoading: Bool
    var launches: [RocketLaunch]
    var error: String

    init(isLoading: Bool = false, launches: [RocketLaunch] = [], error: String = "") {
        self.isLoading = isLoading
        self.launches = launches
        self.error = error
    }
}

