//
//  VolunteerOnboardingViewController.swift
//  Sewa-iOS
//
//  Created by Vikram Grewal on 11/3/19.
//  Copyright © 2019 Vikram Grewal. All rights reserved.
//

import UIKit
import LTHRadioButton

class VolunteerOnboardingViewController: UIViewController {

    @IBOutlet weak var volunteerOnboardingFormStackView: UIStackView!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        title = "Sewa"
        navigationController?.setNavigationStyle()
        setupForm()
    }
    
    override var preferredStatusBarStyle: UIStatusBarStyle {
        return .lightContent
    }
    
    private func setupForm() {
        let questions = [
            "Do you have a car?",
            "Is it okay if somebody drives you?",
            "Can you drive somebody?",
            "Are you interested in Sewa Internships?",
            "Are you in the medical field?",
            "Can you teach something?",
            "Can you mentor someone?"
        ]
        
        for index in 0..<6 {
            let label = UILabel()
            label.text = questions[index]
            label.sizeToFit()
            label.font = UIFont.boldSystemFont(ofSize: 17.0)
        
            let horizontalStackView = UIStackView()
            horizontalStackView.axis = .horizontal
            horizontalStackView.distribution = .fillEqually
            horizontalStackView.translatesAutoresizingMaskIntoConstraints = false
            horizontalStackView.heightAnchor.constraint(equalToConstant: 44.0).isActive = true
            
            let yesView = UIView()
            yesView.translatesAutoresizingMaskIntoConstraints = false
            yesView.heightAnchor.constraint(equalToConstant: 44.0).isActive = true
            
            let yesRadioButton = LTHRadioButton(diameter: 18.0, selectedColor: Constants.Colors.appBlue, deselectedColor: .lightGray)
            yesRadioButton.translatesAutoresizingMaskIntoConstraints = false
            
            let yesLabel = UILabel()
            yesLabel.translatesAutoresizingMaskIntoConstraints = false
            yesLabel.text = "Yes"
            yesLabel.sizeToFit()
            yesLabel.font = UIFont.boldSystemFont(ofSize: 15.0)
            
            yesView.addSubview(yesRadioButton)
            yesView.addSubview(yesLabel)
            
            NSLayoutConstraint.activate([
                yesRadioButton.leadingAnchor.constraint(equalTo: yesView.leadingAnchor),
                yesRadioButton.centerYAnchor.constraint(equalTo: yesView.centerYAnchor),
                yesRadioButton.heightAnchor.constraint(equalToConstant: 18.0),
                yesRadioButton.widthAnchor.constraint(equalToConstant: 18.0),
                yesLabel.leadingAnchor.constraint(equalTo: yesRadioButton.trailingAnchor, constant: 8.0),
                yesLabel.centerYAnchor.constraint(equalTo: yesView.centerYAnchor)
            ])
            
            let noView = UIView()
            noView.translatesAutoresizingMaskIntoConstraints = false
            noView.heightAnchor.constraint(equalToConstant: 44.0).isActive = true
            
            let noRadioButton = LTHRadioButton(diameter: 18.0, selectedColor: Constants.Colors.appBlue, deselectedColor: .lightGray)
            noRadioButton.translatesAutoresizingMaskIntoConstraints = false
            
            let noLabel = UILabel()
            noLabel.translatesAutoresizingMaskIntoConstraints = false
            noLabel.text = "No"
            noLabel.sizeToFit()
            noLabel.font = UIFont.boldSystemFont(ofSize: 15.0)

            
            noRadioButton.onSelect {
                noRadioButton.select()
                yesRadioButton.deselect()
            }
            
            yesRadioButton.onSelect {
                yesRadioButton.select()
                noRadioButton.deselect()
            }
                        
            noView.addSubview(noRadioButton)
            noView.addSubview(noLabel)
            
            let randomSelect = Int.random(in: 0...1)
            randomSelect == 0 ? yesRadioButton.select() : noRadioButton.select()
            
            NSLayoutConstraint.activate([
                noRadioButton.leadingAnchor.constraint(equalTo: noView.leadingAnchor),
                noRadioButton.centerYAnchor.constraint(equalTo: noView.centerYAnchor),
                noRadioButton.heightAnchor.constraint(equalToConstant: 18.0),
                noRadioButton.widthAnchor.constraint(equalToConstant: 18.0),
                noLabel.leadingAnchor.constraint(equalTo: noRadioButton.trailingAnchor, constant: 8.0),
                noLabel.centerYAnchor.constraint(equalTo: noView.centerYAnchor)
            ])
            
            horizontalStackView.addArrangedSubview(yesView)
            horizontalStackView.addArrangedSubview(noView)
        
            volunteerOnboardingFormStackView.addArrangedSubview(label)
            volunteerOnboardingFormStackView.addArrangedSubview(horizontalStackView)
            
            volunteerOnboardingFormStackView.setCustomSpacing(8.0, after: label)
            volunteerOnboardingFormStackView.setCustomSpacing(16.0, after: horizontalStackView)
        }
        
        let continueButton = UIButton(type: .roundedRect)
        continueButton.layer.cornerRadius = Constants.Styling.buttonCornerRadius
        continueButton.translatesAutoresizingMaskIntoConstraints = false
        continueButton.heightAnchor.constraint(equalToConstant: 44).isActive = true
        continueButton.widthAnchor.constraint(equalToConstant: 100).isActive = true
        continueButton.setTitle("Continue", for: .normal)
        continueButton.setTitleColor(.white, for: .normal)
        continueButton.titleLabel?.font = UIFont.boldSystemFont(ofSize: 18)
        continueButton.backgroundColor = Constants.Colors.appBlue
        
        continueButton.addTarget(self, action: #selector(showTabs), for: .touchUpInside)
        
        volunteerOnboardingFormStackView.addArrangedSubview(continueButton)
    }
    
    @objc private func showTabs() {
        DispatchQueue.main.async { [weak self] in
            self?.performSegue(withIdentifier: "showTabsSegue", sender: self)
        }
    }
    
    
    

    
    // MARK: - Navigation
    
    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
        if
            segue.identifier == "showTabsSegue",
            let tabBarController = segue.destination as? UITabBarController,
            let nc = tabBarController.viewControllers?[0] as? UINavigationController,
            let vc = nc.viewControllers[0] as? TasksViewController
        {
            vc.addTasksDisabled = true
        }
        
        
    }
    

}
