//
//  LoadingIndicator.swift
//  iosApp
//
//  Created by ahmed elbagory on 10/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct LoadingIndicator: View {
    var body: some View {
        HStack {
            ProgressView()
                .frame(width: 28, height: 28)
            Text("Loading...")
        }
        .padding()
    }
}
