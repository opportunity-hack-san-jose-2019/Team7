//
//  Network.swift
//  Sewa-iOS
//
//  Created by Vikram Grewal on 11/3/19.
//  Copyright © 2019 Vikram Grewal. All rights reserved.
//

import Foundation
import Alamofire
import SwiftyJSON

struct Login:Encodable, Decodable {
   let username:String
   let password:String
}

struct SignUp:Encodable, Decodable{
   let firstName : String
    let lastName : String
   let phoneNumber : String
   let email : String
   let address : String
   let city : String
    let state : String
   let zipcode : String
   let language : String

}

struct TaskRequest:Encodable, Decodable{
    let is_finished : Bool
}

struct Task: Encodable, Decodable {
    let category: String
    let subcategory: String
    let purpose: String
    let details: String
    let address : String
    let city : String
     let state : String
    let zipcode : String
    let requestor_id: String
    let volunteer_id: String
}

class NetworkAPI {

    private init() { }

    static let singleton = NetworkAPI()

    func fetchLoginData(login:Login, completion: ((AFError?, Bool?) -> ())?) {
//        let userName = login.username;
//        let password = login.password;

        let url = "https://withsewa.herokuapp.com/user/login";
       // let login = login //Login(username: userName, password: password);
        AF.request(url,
                   method: .post,
                   parameters: login,
                   encoder: JSONParameterEncoder.default).response{ response in
                    if let error = response.error {
                        completion?(error, nil)
                    }

                    completion?(nil, true)

        }
    }


    func submitSignUpData(signUp:SignUp,completion : ((AFError? , Bool?) -> ())?){

        let signUpURL = "https://withsewa.herokuapp.com/user/signup";

      //  let signUpPadLoad = signUp;

        AF.request(signUpURL,
                   method: .post,
                   parameters: signUp,
                   encoder: JSONParameterEncoder.default).response{ response in
                    if let error = response.error{
                        completion?(error,nil)

                    }
                    completion?(nil,true)
                    }
        }

    
    func retrieveAllTasks(tasks:TaskRequest, completion : ((Error?,[Task]?) -> ())?){
        let taskRetrieveURL = "https://withsewa.herokuapp.com/task/getall";
        
        AF.request(taskRetrieveURL,method: .post,parameters: tasks,encoder: JSONParameterEncoder.default).response{response in
            if let error = response.error{
                completion?(error,nil)
                
            }
            do {
                if
                    let data = response.data
                {
                    let json = try JSON(data: data)
                    let tasksJson = (json.dictionaryObject?["entity"] as? [String:[Any]])?["tasks"] ?? []
                    var tasks: [Task] = [Task]()
                    for taskJson in tasksJson {
                        guard let taskKeys = taskJson as? [String:Any] else { return }
                        
                        let category: String = taskKeys["category"] as? String ?? ""
                        let subcategory: String = taskKeys["subcategory"] as? String ?? ""
                        let purpose: String = taskKeys["purpose"] as? String ?? ""
                        let details: String = taskKeys["details"] as? String ?? ""
                        let address : String = taskKeys["address"] as? String ?? ""
                        let city : String = taskKeys["city"] as? String ?? ""
                         let state : String = taskKeys["state"] as? String ?? ""
                        let zipcode : String = taskKeys["zipcode"] as? String ?? ""
                        let requestor_id: String = taskKeys["requestor_id"] as? String ?? ""
                        let volunteer_id: String = taskKeys["volunteer_id"] as? String ?? ""
                        
                        let task = Task(category: category, subcategory: subcategory, purpose: purpose, details: details, address: address, city: city, state: state, zipcode: zipcode, requestor_id: requestor_id, volunteer_id: volunteer_id)
                        tasks.append(task)
                    }
                    
                    completion?(nil, tasks)
                } else {
                    completion?(nil, nil)
                }
                
            } catch {
                completion?(error, nil)
            }
            
        }
        
    }
    
    


}
