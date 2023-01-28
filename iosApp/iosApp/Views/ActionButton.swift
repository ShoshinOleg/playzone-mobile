//
//  ActionButton.swift
//  iosApp
//
//  Created by Oleg on 27.01.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct ActionButton: View {
    
    let title: String
    var isEnabled: Bool = true
    let height: CGFloat = 56
    let horizontalMargin: CGFloat = 16
    let action: () -> Void
    
    var body: some View {
        ZStack {
            RoundedRectangle(cornerRadius: 10)
                .foregroundColor(.tint)
                .opacity(isEnabled ? 1.0 : 0.5)
            
            Text(title)
                .foregroundColor(.textAction)
        }
        .frame(maxWidth: .infinity, minHeight: height)
        .padding(EdgeInsets(top: 0, leading: horizontalMargin, bottom: 0, trailing: horizontalMargin))
        .onTapGesture {
            action()
        }
    }
}

struct ActionButton_Previews: PreviewProvider {
    static var previews: some View {
        ActionButton(title: "Login Now", action: {})
    }
}
