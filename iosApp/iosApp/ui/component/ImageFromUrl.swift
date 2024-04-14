//
//  ImageFromUrl.swift
//  iosApp
//
//  Created by ahmed elbagory on 10/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct ImageFromUrl: View {
    let url: String
    let contentDescription: String
    let contentMode: ContentMode
    let placeholder: Image?

    var body: some View {
        AsyncImage(url: URL(string: url)!) { phase in
                   switch phase {
                   case .success(let image):
                       image
                           .resizable()
                           .aspectRatio(contentMode: contentMode)
                           .accessibility(label: Text(contentDescription))
                   case .failure(_):
                       placeholder?.resizable() ?? Image("placeholder")
                   case .empty:
                       placeholder?.resizable() ?? Image("placeholder")
                   @unknown default:
                       placeholder?.resizable() ?? Image("placeholder")
                   }
               }
           }
       
        }

