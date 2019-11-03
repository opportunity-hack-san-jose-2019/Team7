//
//  TaskTableViewCell.swift
//  Sewa-iOS
//
//  Created by Vikram Grewal on 11/3/19.
//  Copyright © 2019 Vikram Grewal. All rights reserved.
//

import UIKit

class TaskTableViewCell: UITableViewCell {
    
    @IBOutlet weak var taskName: UILabel!
    @IBOutlet weak var taskAddress: UILabel!
    @IBOutlet weak var taskStackView: UIStackView!
    
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
