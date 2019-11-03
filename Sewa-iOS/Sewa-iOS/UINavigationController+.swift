//
//  UINavigationController+.swift
//  Sewa-iOS
//
//  Created by Vikram Grewal on 11/3/19.
//  Copyright © 2019 Vikram Grewal. All rights reserved.
//

import Foundation
import UIKit

extension UINavigationController {
   open override var preferredStatusBarStyle: UIStatusBarStyle {
      return topViewController?.preferredStatusBarStyle ?? .default
   }
    
    func setNavigationStyle() {
        navigationBar.titleTextAttributes = [
            .foregroundColor: UIColor.white,
            .font: UIFont(name: "ArialRoundedMTBold", size: 24)
        ]
        navigationBar.tintColor = .white
        navigationBar.barTintColor = Constants.Colors.appBlue
    }
}
