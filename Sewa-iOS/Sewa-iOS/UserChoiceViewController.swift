//
//  UserChoiceViewController.swift
//  Sewa-iOS
//
//  Created by Vikram Grewal on 11/3/19.
//  Copyright © 2019 Vikram Grewal. All rights reserved.
//

import UIKit

class UserChoiceViewController: UIViewController {
    
    @IBOutlet weak var volunteerButton: UIButton!
    @IBOutlet weak var userButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        volunteerButton.addTarget(self, action: #selector(redirectUser(_:)), for: .touchUpInside)
        userButton.addTarget(self, action: #selector(redirectUser(_:)), for: .touchUpInside)
        volunteerButton.layer.cornerRadius = Constants.Styling.buttonCornerRadius
        userButton.layer.cornerRadius = Constants.Styling.buttonCornerRadius
        volunteerButton.titleLabel?.font = UIFont.boldSystemFont(ofSize: 17)
        userButton.titleLabel?.font = UIFont.boldSystemFont(ofSize: 17)
    }
    
    override var preferredStatusBarStyle: UIStatusBarStyle {
        return .lightContent
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */
    
    @objc private func redirectUser(_ sender: UIButton) {
        switch sender {
        case volunteerButton:
            
            break
        case userButton:
            
            break
        default:
            return
        }
    }

}
