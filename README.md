
CRUD Application
-----------
Spring boot, Jpa, Mysql
----
<h6>Requirements:
     Mysql
</h6>

<h6>When Application starts it will save some initial data to tables</h6>


 <h4>ITEM API:</b>
 
 1) <b>Get All items:</b>

 
    Request: http://localhost:8080/item/list
    Response:
     [{"id":1,"name":"soap","stocks":1000,"unitPrice":10.5,"description":"Baby Soap"},{"id":2,"name":"Tooth Brush","stocks":500,"unitPrice":45.5,"description":"Tooth Brush"},{"id":3,"name":"Shirt","stocks":100,"unitPrice":1500.0,"description":"Shirt"},{"id":4,"name":"Office Bag","stocks":400,"unitPrice":10000.0,"description":"Office Bag"},{"id":5,"name":"Bottle","stocks":800,"unitPrice":450.5,"description":"Bottle"}]
    
 2) <b>Get Item by Id:</b>


    Request: http://localhost:8080/item/5
    Response:
     {"id":5,"name":"Bottle","stocks":800,"unitPrice":450.5,"description":"Bottle"}
   
 3) <b>Add a Item:</b>
 
 
    Request: 
       url:
        http://localhost:8080/item/add
       type:
        POST
       request Header:
        Content-Type:application/json
       body:
        {"name":"sanitizer",
         "stocks":"40",
         "unitPrice":"80.0",
         "description":"Sanitizer"
        }
        
    Response:
        Item Added Successfully !
        
 4)  <b>Update a name and description of give item id:</b>
 
  
     Request: 
        url:
         http://localhost:8080/item/update/4
        type:
         PUT
        request Header:
         Content-Type:application/json
        body:
         {"name":"Office Bag imported from US",
          "description":"Office Bag imported from US"
         }
         
     Response:
         Item Updated Successfully !
 
 5) <b>Delete Item of give item id:</b>
 
  
     Request:
        url:
         http://localhost:8080/item/delete/3
        type:
         DELETE
        request Header:
         Content-Type:application/json
         
     Response:
         Item with given Id is deleted Successfully !
             
-----
<h4>ORDER API</h4>

1) <b>Single Order:</b>


    Request: 
        url:
         http://localhost:8080/order
        type:
         POST
        request Header:
         Content-Type:application/json
        body:
         {"customer":{"id":"1"},
          "itemOrdered": {"item":{"id":"1"},"quantity":"10"},
         "type":"SINGLE"
        }
         
    Response:
        SUCCESS
    
 2) <b>Bulk Order:</b>
 

    Request: 
        url:
         http://localhost:8080/order
        type:
         POST
        request Header:
         Content-Type:application/json
        body:
         {"customer":{"id":"1"},
          "itemOrdered": {"item":{"id":"1"},"quantity":"10"},
         "type":"BULK"
        }
         
    Response:
        SUCCESS