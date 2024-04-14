//
//  ErrorHolder.swift
//  iosApp
//
//  Created by ahmed elbagory on 10/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct ErrorHolder: View {
    let error: String

    var body: some View {
        VStack {
            Image("error")
                .resizable()
                .aspectRatio(contentMode: .fit)
                .frame(width: 250, height: 250)
            Text(error)
                .padding(8)
                .font(.body)
                .fontWeight(.bold)
        }
        .padding()
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color.white)
    }
}
