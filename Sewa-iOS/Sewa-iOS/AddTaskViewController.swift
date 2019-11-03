//
//  AddTaskViewController.swift
//  Sewa-iOS
//
//  Created by Vikram Grewal on 11/3/19.
//  Copyright © 2019 Vikram Grewal. All rights reserved.
//

import UIKit

class AddTaskViewController: UIViewController {
    
    @IBOutlet weak var categoryStackView: UIStackView!
    @IBOutlet weak var subcategoryPickerView: UIPickerView!
    private var selectedCategory: String!
    @IBOutlet weak var pickerHeightConstraint: NSLayoutConstraint!
    
    private let subcategoryMap: [String: [String]] = [
        "Disaster Relief": [
            "Emergency Relief",
            "Education",
            "Empowerment",
            "Health",
            "Community Devlopment"
        ],
        "Family Services": [
            "Education",
            "Empowerment",
            "Health",
            "Community Development"
        ],
        "Volunteer Development": [
            "Community Development"
        ],
        "Development": [
            "Education",
            "Empowerment",
            "Health",
            "Community Development"
        ],
        "Sponsor A Child": [
            "Education",
            "Empowerment",
            "Health"
        ],
        "Public Hygiene And Empowerment": [
            "Empowerment",
            "Health",
            "Community Development"
        ]
    ]

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        title = "Add Task"
        navigationController?.setNavigationStyle()
        setNavigationItem()
        setForm()
    }
    
    private func setForm() {
        categoryStackView.spacing = 12.0
        
        let taskTextField = UITextField()
        taskTextField.placeholder = "Enter task"
        taskTextField.borderStyle = .roundedRect
        taskTextField.tag = 0
        taskTextField.delegate = self
        taskTextField.isUserInteractionEnabled = true
        taskTextField.translatesAutoresizingMaskIntoConstraints = false
        taskTextField.heightAnchor.constraint(equalToConstant: 44.0).isActive = true
        
        categoryStackView.addArrangedSubview(taskTextField)
        
        let detailsLabel = UILabel()
        detailsLabel.text = "Enter details below:"
        detailsLabel.textColor = .darkGray
        detailsLabel.sizeToFit()
        detailsLabel.tag = 1

        categoryStackView.addArrangedSubview(detailsLabel)
        
        let detailsTextView = UITextView()
        detailsTextView.layer.cornerRadius = Constants.Styling.buttonCornerRadius
        detailsTextView.layer.borderColor = UIColor.groupTableViewBackground.cgColor
        detailsTextView.layer.borderWidth = 1.0
        detailsTextView.translatesAutoresizingMaskIntoConstraints = false
        detailsTextView.heightAnchor.constraint(equalToConstant: 120).isActive = true
        detailsTextView.tag = 2
        
        categoryStackView.addArrangedSubview(detailsTextView)
        
        let addressTextField = UITextField()
        addressTextField.placeholder = "Enter address"
        addressTextField.borderStyle = .roundedRect
        addressTextField.tag = 3
        
        categoryStackView.addArrangedSubview(addressTextField)
        
        setLabels()
        
        let button = UIButton(type: .roundedRect)
        button.layer.cornerRadius = Constants.Styling.buttonCornerRadius
        button.translatesAutoresizingMaskIntoConstraints = false
        button.heightAnchor.constraint(equalToConstant: 44).isActive = true
        button.widthAnchor.constraint(equalToConstant: 100).isActive = true
        button.setTitle("Save", for: .normal)
        button.setTitleColor(.white, for: .normal)
        button.titleLabel?.font = UIFont.boldSystemFont(ofSize: 18)
        button.backgroundColor = Constants.Colors.appBlue
        button.addTarget(self, action: #selector(saveTask), for: .touchUpInside)
        
        categoryStackView.addArrangedSubview(button)
    }
    
    private func setLabels() {
        let detailsLabel = UILabel()
        detailsLabel.text = "Select category below:"
        detailsLabel.textColor = .darkGray
        detailsLabel.sizeToFit()
        detailsLabel.tag = 1
        
        categoryStackView.addArrangedSubview(detailsLabel)
        
        for key in subcategoryMap.keys {
            let label = UILabel()
            label.text = key
            label.isUserInteractionEnabled = true
            let gestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(openSubcategoryPicker(_:)))
            label.addGestureRecognizer(gestureRecognizer)
            
            categoryStackView.addArrangedSubview(label)
        }
    }
    
    private func setNavigationItem() {
        navigationItem.rightBarButtonItem = nil
    }
    
    @objc private func saveTask() {
        navigationController?.dismiss(animated: true, completion: nil)
    }
    
    @objc private func openSubcategoryPicker(_ sender: UITapGestureRecognizer) {
        
        guard
            let label = sender.view as? UILabel,
            let category = label.text
        else { return }
        
        let selectButton = UIBarButtonItem(title: "Select", style: .plain, target: self, action: #selector(saveCategory(_:)))
        navigationItem.rightBarButtonItem = selectButton
        
        selectedCategory = category
        subcategoryPickerView.delegate = self
        subcategoryPickerView.dataSource = self
        subcategoryPickerView.isHidden = false
        pickerHeightConstraint.constant = 200
        subcategoryPickerView.layoutIfNeeded()
    }

    
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    

}

extension AddTaskViewController: UIPickerViewDelegate, UIPickerViewDataSource {
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        guard let _ = subcategoryMap[selectedCategory]?.count else { return 0 }
        
        return 1
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        guard let subcategoryCount = subcategoryMap[selectedCategory]?.count else { return 0 }
        
        return subcategoryCount
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return subcategoryMap[selectedCategory]?[row]
    }
    
    @objc private func saveCategory(_ sender: UIButton) {
        let subcategory = subcategoryMap[selectedCategory]?[subcategoryPickerView.selectedRow(inComponent: 0)]
        pickerHeightConstraint.constant = 0
        subcategoryPickerView.layoutIfNeeded()
        setNavigationItem()
    }
    
}

extension AddTaskViewController: UITextFieldDelegate {
    func textField(_ textFitexteld: UITextField, shouldChangeCharactersIn range: NSRange, replacementString string: String) -> Bool {
        return true
    }
}
