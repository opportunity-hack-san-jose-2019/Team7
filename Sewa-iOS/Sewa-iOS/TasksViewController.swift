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
    @IBOutlet weak var tasksTableView: UITableView!
    var tasks: [Task] = [Task]()
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        title = "Tasks"
        tasksTableView.register(UINib(nibName: "TaskTableViewCell", bundle: nil), forCellReuseIdentifier: "TaskTableViewCell")
        tasksTableView.tableFooterView = UIView()
        tasksTableView.rowHeight = UITableView.automaticDimension
        tasksTableView.delegate = self
        tasksTableView.dataSource = self
        navigationController?.setNavigationStyle()
        setNavigationItem()
        fetchData()
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

extension TasksViewController: UITableViewDelegate, UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return tasks.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "TaskTableViewCell") as? TaskTableViewCell else {
            return UITableViewCell()
        }
        
        cell.taskAddress.text = "\(tasks[indexPath.row].address), \(tasks[indexPath.row].city), \(tasks[indexPath.row].state) \(tasks[indexPath.row].zipcode)"
        cell.taskName.text = "\(tasks[indexPath.row].purpose)"
        cell.taskName.font = UIFont.boldSystemFont(ofSize: 15)
        cell.taskName.textColor = .white
        cell.taskAddress.textColor = .white
        cell.taskAddress.font = cell.taskAddress.font.withSize(13)
        
        cell.backgroundColor = indexPath.row % 2 == 0 ? UIColor.lightGray : Constants.Colors.appBlue
        
        return cell
    }
    
    private func fetchData() {
        let tasks = TaskRequest(is_finished: false)
        NetworkAPI.singleton.retrieveAllTasks(tasks: tasks) { (error, tasks) in
            guard let tasks = tasks else { return }
            
            self.tasks = tasks
            self.tasksTableView.reloadData()
        }
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        DispatchQueue.main.async {
            let task = self.tasks[indexPath.row]
            guard let vc = UIStoryboard(name: "Main", bundle: nil).instantiateViewController(withIdentifier: "AddTaskViewController") as? AddTaskViewController else { return }
            
            vc.task = task
            vc.modalPresentationStyle = .fullScreen
            
            self.navigationController?.pushViewController(vc, animated: true)
        }
        
        
        tableView.deselectRow(at: indexPath, animated: true)
    }
}
