//
//  Constants.swift
//  Sewa-iOS
//
//  Created by Vikram Grewal on 11/3/19.
//  Copyright © 2019 Vikram Grewal. All rights reserved.
//

import Foundation
import UIKit

struct Constants {
    struct Registration {
        static let loginIndex = 0
        static let signupIndex = 1
        
        struct Login {
            static let emailIndex = 0
            static let passwordIndex = 1
            
            static let placeholderText = [
                "Enter email address",
                "Enter password"
            ]
        }
        
        struct SignUp {
            static let firstNameIndex = 0
            static let lastNameIndex = 1
            static let phoneNumberIndex = 2
            static let emailIndex = 3
            static let addressIndex = 4
            static let cityIndex = 5
            static let stateIndex = 6
            static let zipCodeIndex = 7
            
            static let placeholderText = [
                "Enter first name",
                "Enter last name",
                "Enter phone number",
                "Enter email",
                "Enter address",
                "Enter city",
                "Enter state",
                "Enter zip code"
            ]
            
            
        }
    }
    
    struct Styling {
        static let buttonCornerRadius: CGFloat = 5.0
        
        static var continueButton: UIButton {
            let button = UIButton(type: .roundedRect)
            button.layer.cornerRadius = Constants.Styling.buttonCornerRadius
            button.translatesAutoresizingMaskIntoConstraints = false
            button.heightAnchor.constraint(equalToConstant: 44).isActive = true
            button.widthAnchor.constraint(equalToConstant: 100).isActive = true
            button.setTitle("Continue", for: .normal)
            button.setTitleColor(.white, for: .normal)
            button.titleLabel?.font = UIFont.boldSystemFont(ofSize: 18)
            button.backgroundColor = Constants.Colors.appBlue
            
            return button
        }
    }
    
    struct Colors {
        static let appBlue = UIColor(red: 0/255, green: 120/255, blue: 194/255, alpha: 1.0)
    }

}
