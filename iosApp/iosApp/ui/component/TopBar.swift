//
//  TopBar.swift
//  iosApp
//
//  Created by ahmed elbagory on 10/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct TopBar: View {
    @Environment(\.dismiss) var dismiss
    let title: String
    let menu: (() -> Void)?
    
    var body: some View {
        HStack {
            Button(action: {
                dismiss()
            }) {
                Label("", systemImage: "chevron.backward")
                    .foregroundColor(.white)
                
            }
            
            Text(title)
                .font(.headline)
                .foregroundColor(.white)
            Spacer()
            if let menu = menu {
                Button(action: menu) {
                    Image(systemName: "ellipsis.circle.fill")
                        .foregroundColor(.white)
                }
            }
        }
        .padding()
        .background(Color.black)
    }
}

