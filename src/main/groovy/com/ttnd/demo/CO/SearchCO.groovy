package com.ttnd.demo.CO

import grails.validation.Validateable

class SearchCO implements Validateable {
    String sortColumn = "id"
    String order
    String sort
    String q
    Integer max
    Integer offset
}
