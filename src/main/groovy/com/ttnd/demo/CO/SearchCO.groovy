package com.ttnd.demo.CO

import grails.validation.Validateable
import grails.converters.JSON
import org.grails.web.json.JSONArray
import org.grails.web.json.JSONObject

class SearchCO implements Validateable {

    Integer length
    Integer start

    String order
    String columns
    String search


    String fetchSearchValue(){
        JSONObject js = JSON.parse(search)
        return  js.get('value')
    }

    Integer fetchColumnIndex(){
        JSONArray js = JSON.parse(order)
        return  js.first().get("column")
    }

    String fetchSortingOrder(){
        JSONArray js = JSON.parse(order)
        return js.first().get("dir").trim()
    }

    String fetchSortProperty(){
        JSONArray js = JSON.parse(columns)
        return js.getJSONObject(fetchColumnIndex()).get("data").trim()
    }
}
