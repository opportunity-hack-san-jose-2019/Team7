//
//  DonateViewController.swift
//  Sewa-iOS
//
//  Created by Vikram Grewal on 11/3/19.
//  Copyright © 2019 Vikram Grewal. All rights reserved.
//

import UIKit

class DonateViewController: UIViewController {

    @IBOutlet weak var paypalDonateButton: UIButton!
    @IBOutlet weak var donateButton: UIButton!
    override func viewDidLoad() {
        super.viewDidLoad()
        
        title = "Donate"
        navigationController?.setNavigationStyle()
        
        donateButton.layer.cornerRadius = Constants.Styling.buttonCornerRadius
        donateButton.addTarget(self, action: #selector(donate), for: .touchUpInside)
        
        paypalDonateButton.backgroundColor = UIColor(red:0.00, green:0.44, blue:0.73, alpha:1.0)
        paypalDonateButton.setTitle("Donate With Paypal", for: .normal)
        paypalDonateButton.layer.cornerRadius = Constants.Styling.buttonCornerRadius
        paypalDonateButton.addTarget(self, action: #selector(donateWithPaypal), for: UIControl.Event.touchUpInside)
        

        // Do any additional setup after loading the view.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */
    
    @objc private func donate() {
        let appUrlString = "https://www.sewausa.org/Donate"
        if let appUrl = URL(string: appUrlString) {
            UIApplication.shared.open(appUrl, options: [:], completionHandler: nil)
        }
        
        
    }

    
    @objc private func donateWithPaypal() {
        let appUrlString = "https://www.paypal.com/fundraiser/charity/119649"
        if let appUrl = URL(string: appUrlString) {
            UIApplication.shared.open(appUrl, options: [:], completionHandler: nil)
        }
        
        
    }
    
    
}
