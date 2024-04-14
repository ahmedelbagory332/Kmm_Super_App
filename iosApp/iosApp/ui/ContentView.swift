//
//  ContentView.swift
//  iosApp
//
//  Created by ahmed elbagory on 13/04/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct ContentView: View {
    @State private var items: [String] = []
    @State private var isLoading = false
    @State private var isAtBottom = false
    @State private var bottomID: String? = nil
    
    var body: some View {
        ScrollView {
            ScrollViewReader { proxy in
                LazyVStack(spacing: 20) {
                    ForEach(items, id: \.self) { item in
                        Text(item)
                            .id(item) // Necessary for ScrollViewReader to track views
                            .frame(maxWidth: .infinity)
                            .onAppear {
                                if self.isNearBottom(of: item) {
                                    self.loadMoreData()
                                }
                            }
                    }
                }
                .padding()
                .onAppear {
                    bottomID = items.last
                }
                .onChange(of: isAtBottom) { newValue in
                    if newValue {
                        proxy.scrollTo(bottomID, anchor: .bottom)
                    }
                }
            }
        }
        .onAppear {
            self.loadInitialData()
        }
    }
    
    func loadInitialData() {
        // Simulate initial data loading
        items = (1...10).map { "Item \($0)" }
    }
    
    func loadMoreData() {
        // Simulate loading more data
        isLoading = true
        DispatchQueue.main.asyncAfter(deadline: .now() + 1) {
            self.items.append(contentsOf: (items.count + 1...items.count + 10).map { "More Item \($0)" })
            self.bottomID = items.last // Update bottomID after appending more data
            self.isLoading = false
        }
    }
    
    func isNearBottom(of item: String) -> Bool {
        guard let lastItem = items.last else { return false }
        return item == lastItem
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
