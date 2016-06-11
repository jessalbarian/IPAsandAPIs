//
//  Beer.swift
//  AveryBrewing
//
//  Created by Jessie Albarian on 6/10/16.
//  Copyright © 2016 cocoa touch porter. All rights reserved.
//

import Foundation

class Beer {
    
    var name = String()
    var id = String()
    var url = String()
    var style = String()
    var abv = String()
    var price_per_glass = String()
    var price_per_growler = String()
    
    init(newName: String, newid: String, newUrl: String, newStyle: String, newAbv: String, newPglass: String, newPgrowl: String){
        self.name = newName
        self.id = newid
        self.url = newUrl
        self.style = newStyle
        self.abv = newAbv
        self.price_per_glass = newPglass
        self.price_per_growler = newPgrowl
    }
}