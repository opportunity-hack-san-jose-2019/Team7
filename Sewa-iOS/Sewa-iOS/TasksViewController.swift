//
//  TasksViewController.swift
//  Sewa-iOS
//
//  Created by Vikram Grewal on 11/3/19.
//  Copyright © 2019 Vikram Grewal. All rights reserved.
//

import UIKit

class TasksViewController: UIViewController {
    
    var addTasksDisabled: Bool = false

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        title = "Tasks"
        navigationController?.setNavigationStyle()
        setNavigationItem()
    }
    
    private func setNavigationItem() {
        if addTasksDisabled { return }
        
        navigationItem.rightBarButtonItem = UIBarButtonItem(barButtonSystemItem: .add, target: self, action: #selector(addTask))
    }
    
    @objc private func addTask() {
        DispatchQueue.main.async { [weak self] in
            guard
                let self = self,
                let addTaskViewContoller = UIStoryboard(name: "Main", bundle: nil).instantiateViewController(withIdentifier: "AddTaskViewController") as? AddTaskViewController
            else { return }
            
            let navigationController = UINavigationController(rootViewController: addTaskViewContoller)
            navigationController.setNavigationStyle()
            navigationController.modalPresentationStyle = .overFullScreen
            
            self.present(navigationController, animated: true, completion: nil)
        }
    }

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
