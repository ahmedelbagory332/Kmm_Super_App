//
//  Chip.swift
//  iosApp
//
//  Created by ahmed elbagory on 11/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI

struct Chip: View {
    let genre: GenreItemModel
    let selected: Bool
    let onSelected: ((GenreItemModel) -> Void)
    
    var body: some View {
        Button(action: {
            onSelected(genre)
        }) {
            Text(genre.name)
                .font(.body)
                .padding(8)
                .foregroundColor(selected ? .white : .primary)
                .background(selected ? Color.blue : Color.white)
                .cornerRadius(10)
                .overlay(
                    RoundedRectangle(cornerRadius: 10)
                        .stroke(selected ? Color.clear : Color.blue, lineWidth: 1)
                )
        }
    }
}
