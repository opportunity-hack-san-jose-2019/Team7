//
//  ViewController.swift
//  Sewa-iOS
//
//  Created by Vikram Grewal on 11/2/19.
//  Copyright © 2019 Vikram Grewal. All rights reserved.
//

import UIKit
import Alamofire



class ViewController: UIViewController {

    @IBOutlet weak var registrationStackView: UIStackView!
    @IBOutlet weak var registrationSegmentedControl: UISegmentedControl!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        title = "Sewa"
        navigationController?.setNavigationStyle()
        registrationSegmentedControl.addTarget(self, action: #selector(changeLoginView(_:)), for: .valueChanged)
        addLogin()
    }
    
    override var preferredStatusBarStyle: UIStatusBarStyle {
        return .lightContent
    }
}

extension ViewController: UITextFieldDelegate {
    
    @objc private func changeLoginView(_ sender: UISegmentedControl) {
        if sender.selectedSegmentIndex == Constants.Registration.loginIndex {
            addLogin()
        } else {
            addSignUp()
        }
    }
    
    private func addLogin() {
        registrationStackView.removeAllArrangedSubviews()
        
        let emailTextField = UITextField()
        emailTextField.borderStyle = .roundedRect
        emailTextField.delegate = self
        emailTextField.placeholder = Constants.Registration.SignUp.placeholderText[Constants.Registration.Login.emailIndex]
        emailTextField.keyboardType = .emailAddress
        emailTextField.tag = Constants.Registration.Login.emailIndex
        
        let passwordTextField = UITextField()
        passwordTextField.borderStyle = .roundedRect
        passwordTextField.delegate = self
        passwordTextField.placeholder = Constants.Registration.Login.placeholderText[Constants.Registration.Login.passwordIndex]
        passwordTextField.isSecureTextEntry = true
        passwordTextField.tag = Constants.Registration.Login.passwordIndex
        
        registrationStackView.spacing = 16.0
        
        let continueButton = UIButton(type: .roundedRect)
        continueButton.layer.cornerRadius = Constants.Styling.buttonCornerRadius
        continueButton.translatesAutoresizingMaskIntoConstraints = false
        continueButton.heightAnchor.constraint(equalToConstant: 44).isActive = true
        continueButton.widthAnchor.constraint(equalToConstant: 100).isActive = true
        continueButton.setTitle("Continue", for: .normal)
        continueButton.setTitleColor(.white, for: .normal)
        continueButton.titleLabel?.font = UIFont.boldSystemFont(ofSize: 18)
        continueButton.backgroundColor = Constants.Colors.appBlue
        
        registrationStackView.addArrangedSubview(emailTextField)
        registrationStackView.addArrangedSubview(passwordTextField)
        registrationStackView.addArrangedSubview(continueButton)
        
        DispatchQueue.main.asyncAfter(deadline: .now() + 1.0) {
            emailTextField.text = "RickyPham@gmail.com"
            passwordTextField.text = "Password"
        }
        
        continueButton.addTarget(self, action: #selector(continuePressed), for: .touchUpInside)
    }
    
    private func addSignUp() {
        registrationStackView.removeAllArrangedSubviews()
        
        let firstNameTextField = UITextField()
        firstNameTextField.borderStyle = .roundedRect
        firstNameTextField.delegate = self
        firstNameTextField.placeholder = Constants.Registration.SignUp.placeholderText[Constants.Registration.SignUp.firstNameIndex]
        firstNameTextField.tag = Constants.Registration.SignUp.firstNameIndex
        
        let lastNameTextField = UITextField()
        lastNameTextField.borderStyle = .roundedRect
        lastNameTextField.delegate = self
        lastNameTextField.placeholder = Constants.Registration.SignUp.placeholderText[Constants.Registration.SignUp.lastNameIndex]
        lastNameTextField.tag = Constants.Registration.SignUp.lastNameIndex
        
        let phoneTextField = UITextField()
        phoneTextField.borderStyle = .roundedRect
        phoneTextField.delegate = self
        phoneTextField.placeholder = Constants.Registration.SignUp.placeholderText[Constants.Registration.SignUp.phoneNumberIndex]
        phoneTextField.keyboardType = .phonePad
        phoneTextField.tag = Constants.Registration.SignUp.phoneNumberIndex
        
        let emailTextField = UITextField()
        emailTextField.borderStyle = .roundedRect
        emailTextField.delegate = self
        emailTextField.placeholder = Constants.Registration.SignUp.placeholderText[Constants.Registration.SignUp.emailIndex]
        emailTextField.keyboardType = .emailAddress
        emailTextField.tag = Constants.Registration.SignUp.emailIndex
        
        let addressTextField = UITextField()
        addressTextField.borderStyle = .roundedRect
        addressTextField.delegate = self
        addressTextField.placeholder = Constants.Registration.SignUp.placeholderText[Constants.Registration.SignUp.addressIndex]
        addressTextField.tag = Constants.Registration.SignUp.addressIndex
        
        let passwordTextField = UITextField()
        passwordTextField.borderStyle = .roundedRect
        passwordTextField.placeholder = Constants.Registration.Login.placeholderText[Constants.Registration.Login.passwordIndex]
        passwordTextField.isSecureTextEntry = true
        
        let cityTextField = UITextField()
        cityTextField.borderStyle = .roundedRect
        cityTextField.delegate = self
        cityTextField.placeholder = Constants.Registration.SignUp.placeholderText[Constants.Registration.SignUp.cityIndex]
        cityTextField.tag = Constants.Registration.SignUp.cityIndex
        
        let stateTextField = UITextField()
        stateTextField.borderStyle = .roundedRect
        stateTextField.delegate = self
        stateTextField.placeholder = Constants.Registration.SignUp.placeholderText[Constants.Registration.SignUp.stateIndex]
        stateTextField.tag = Constants.Registration.SignUp.stateIndex
        
        let zipCodeTextField = UITextField()
        zipCodeTextField.borderStyle = .roundedRect
        zipCodeTextField.delegate = self
        zipCodeTextField.placeholder = Constants.Registration.SignUp.placeholderText[Constants.Registration.SignUp.zipCodeIndex]
        zipCodeTextField.tag = Constants.Registration.SignUp.zipCodeIndex
        
        registrationStackView.spacing = 16.0
        
        let continueButton = UIButton(type: .roundedRect)
        continueButton.layer.cornerRadius = Constants.Styling.buttonCornerRadius
        continueButton.translatesAutoresizingMaskIntoConstraints = false
        continueButton.heightAnchor.constraint(equalToConstant: 44).isActive = true
        continueButton.widthAnchor.constraint(equalToConstant: 100).isActive = true
        continueButton.setTitle("Continue", for: .normal)
        continueButton.setTitleColor(.white, for: .normal)
        continueButton.titleLabel?.font = UIFont.boldSystemFont(ofSize: 18)
        continueButton.backgroundColor = Constants.Colors.appBlue
        
        registrationStackView.addArrangedSubview(firstNameTextField)
        registrationStackView.addArrangedSubview(lastNameTextField)
        registrationStackView.addArrangedSubview(phoneTextField)
        registrationStackView.addArrangedSubview(emailTextField)
        registrationStackView.addArrangedSubview(passwordTextField)
        registrationStackView.addArrangedSubview(addressTextField)
        registrationStackView.addArrangedSubview(cityTextField)
        registrationStackView.addArrangedSubview(stateTextField)
        registrationStackView.addArrangedSubview(zipCodeTextField)
        registrationStackView.addArrangedSubview(continueButton)
        
        DispatchQueue.main.asyncAfter(deadline: .now() + 1.0) {
            firstNameTextField.text = "Ricky"
            lastNameTextField.text = "Pham"
            phoneTextField.text = "4085551243"
            emailTextField.text = "RickyPham@gmail.com"
            passwordTextField.text = "Password"
            addressTextField.text = "4233 Hacker Way"
            cityTextField.text = "Palo Alto"
            stateTextField.text = "CA"
            zipCodeTextField.text = "95121"
        }
        
        
        continueButton.addTarget(self, action: #selector(continuePressed), for: .touchUpInside)
    }
    
    @objc private func continuePressed() {
        DispatchQueue.main.async { [weak self] in
            guard let self = self else { return }
            
            self.performSegue(withIdentifier: "loginSegue", sender: self)
        }
    }

    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
}
