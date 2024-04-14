//
//  HomeState.swift
//  iosApp
//
//  Created by ahmed elbagory on 10/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

struct HomeState: Equatable {
    var homeList: [HomeModel]

    init( homeList: [HomeModel] = []) {
        self.homeList = homeList
    }
}

