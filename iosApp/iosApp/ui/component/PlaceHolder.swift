//
//  PlaceHolder.swift
//  iosApp
//
//  Created by ahmed elbagory on 11/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct PlaceHolder: View {
    let text: String
    let image: Image

    var body: some View {
        VStack {
            image
                .resizable()
                .frame(width: 250, height: 250)
            Spacer().frame(height: 8)
            Text(text)
                .font(.body)
                .fontWeight(.bold)
                .padding(8)
        }
        .padding()
    }
}
