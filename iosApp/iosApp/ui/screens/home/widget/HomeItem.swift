//
//  HomeItem.swift
//  iosApp
//
//  Created by ahmed elbagory on 10/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

import SwiftUI

struct HomeItem: View {
    let homeModel: HomeModel

    var body: some View {
        ZStack {
            RoundedRectangle(cornerRadius: 8)
                .fill(Color.blue.opacity(0.2))
                .shadow(radius: 4)
            
            VStack {
                Image(homeModel.icon as! String)
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 50, height: 50)
                    .padding(12)

                Text(homeModel.name)
                    .foregroundStyle(.black)
                    .font(.body)
                    .fontWeight(.bold)
                    .lineLimit(1)
                    .padding(.horizontal, 12)
                    .padding(.bottom, 8)
            }
        }
        .frame(height: 220)
       
    }
}
