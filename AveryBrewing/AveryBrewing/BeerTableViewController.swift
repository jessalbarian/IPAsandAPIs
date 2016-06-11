//
//  BeerTableViewController.swift
//  AveryBrewing
//
//  Created by Jessie Albarian on 6/10/16.
//  Copyright © 2016 cocoa touch porter. All rights reserved.
//

import UIKit
import Alamofire

var beerList = [String: Beer]()

class BeerTableViewController: UITableViewController {

    // Main Labels for Cell
    @IBOutlet var nameLabel: UILabel!
    @IBOutlet var styleLabel: UILabel!
    @IBOutlet var abvLabel: UILabel!
    
    
    //var beerNamelist = [String]()
    
    
    //--------------------
    // Load JSON from URL
    //--------------------
//    func loadJSON(){
//        let urlPath = "http://apis.mondorobot.com/barrel-aged-beers"
//        guard let url = NSURL(string: urlPath)
//            else {
//                print("url error")
//                return
//        }
//        let session = NSURLSession.sharedSession().dataTaskWithURL(url, completionHandler: {(data, response, error) in
//            let httpResponse = response as! NSHTTPURLResponse
//            let statusCode = httpResponse.statusCode
//            guard statusCode == 200
//                else {
//                    print("file download error")
//                    return
//            }
//            print("download successful")
//            dispatch_async(dispatch_get_main_queue()) { self.parsejson(data!) }
//        })
//        session.resume()
//    }
    
    
    
    
    
    //------------
    // Parse JSON
    //------------
//    func parsejson(data: NSData){
//        do {
//            let json = try NSJSONSerialization.JSONObjectWithData(data, options: NSJSONReadingOptions.AllowFragments) as! NSDictionary
//            
//            // Beer data
//            let allresults = json["beers"] as! NSArray
//            let results = Array(allresults)
//            for item in results {
//                print(item)
//                let name = item["name"] as! String
//                let id = item["id"] as! String
//                let url = item["url"] as! String
//                let style = item["style"] as! String
//                let abv = item["abv"] as! String
//                let price_per_glass = item["price_per_glass"] as! String
//                let price_per_growler = item["price_per_growler"] as! String
//                
//                
//                beerList[name] = Beer(newName: name, newid: id, newUrl: url, newStyle: style, newAbv: abv, newPglass: price_per_glass, newPgrowl: price_per_growler)
//            }
//            
//        } catch {
//            print("Error with JSON: \(error)")
//        }
//        tableView.reloadData()
//    }
//
//    
    func useAlamo(){
        Alamofire.request(.GET, "http://apis.mondorobot.com/beers?")
            .responseJSON { response in
                print(response.request!)  // original URL request
                print(response.response) // URL response
                print(response.data)     // server data
                print(response.result)   // result of response serialization
    
                if let JSON = response.result.value {
                    print("JSON: \(JSON)")
                }
            }
    }
    
    
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        navigationController!.navigationBar.barTintColor = UIColor.whiteColor()
//        navigationController!.navigationBar.tintColor = UIColor.whiteColor()
        
        useAlamo()
//        loadJSON()
//        useAlamo()
        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    // MARK: - Table view data source

    override func numberOfSectionsInTableView(tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 0
    }

    override func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return 0
    }

    /*
    override func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCellWithIdentifier("reuseIdentifier", forIndexPath: indexPath)

        // Configure the cell...

        return cell
    }
    */

    /*
    // Override to support conditional editing of the table view.
    override func tableView(tableView: UITableView, canEditRowAtIndexPath indexPath: NSIndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    */

    /*
    // Override to support editing the table view.
    override func tableView(tableView: UITableView, commitEditingStyle editingStyle: UITableViewCellEditingStyle, forRowAtIndexPath indexPath: NSIndexPath) {
        if editingStyle == .Delete {
            // Delete the row from the data source
            tableView.deleteRowsAtIndexPaths([indexPath], withRowAnimation: .Fade)
        } else if editingStyle == .Insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }    
    }
    */

    /*
    // Override to support rearranging the table view.
    override func tableView(tableView: UITableView, moveRowAtIndexPath fromIndexPath: NSIndexPath, toIndexPath: NSIndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(tableView: UITableView, canMoveRowAtIndexPath indexPath: NSIndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
