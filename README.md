
CRUD Application
-----------
Spring boot, Jpa, Mysql
----
<h6>Requirements:<br>
    a) Mysql
</h6>

<h6>When Application starts it will save some initial data to tables</h6>


 Item api:
 
 1) Get All items:
 
 <p>
    Request: http://localhost:8080/item/list<br>
    Response:<br>
     [{"id":1,"name":"soap","stocks":1000,"unitPrice":10.5,"description":"Baby Soap"},{"id":2,"name":"Tooth Brush","stocks":500,"unitPrice":45.5,"description":"Tooth Brush"},{"id":3,"name":"Shirt","stocks":100,"unitPrice":1500.0,"description":"Shirt"},{"id":4,"name":"Office Bag","stocks":400,"unitPrice":10000.0,"description":"Office Bag"},{"id":5,"name":"Bottle","stocks":800,"unitPrice":450.5,"description":"Bottle"}]
 </p>
    
 2) Get Item by Id:

<p>    
    Request: http://localhost:8080/item/5<br>
    Response:<br>
     {"id":5,"name":"Bottle","stocks":800,"unitPrice":450.5,"description":"Bottle"}
</p> 
   
 3) Add a Item:
 
 <p> 
    Request:<br> 
       url:<br>
        http://localhost:8080/item/add<br>
       type:<br>
        POST<br>
       request Header:<br>
        Content-Type:application/json<br>
       body:<br>
        {"name":"sanitizer",
         "stocks":"40",
         "unitPrice":"80.0",
         "description":"Sanitizer"
        }
        
    Response:<br>
        Item Added Successfully !
 </p>       
 4)  Update a name and description of give item id:
  
 <p>
     Request:<br> 
        url:<br>
         http://localhost:8080/item/update/4<br>
        type:<br>
         PUT<br>
        request Header:<br>
         Content-Type:application/json<br>
        body:<br>
         {"name":"Office Bag imported from US",
          "description":"Office Bag imported from US"
         }
         
     Response:<br>
         Item Updated Successfully !
 </p>
 5) Delete Item of give item id:
  
     Request:<br> 
        url:\
         http://localhost:8080/item/delete/3\
        type:\
         DELETE\
        request Header:\
         Content-Type:application/json\
         
     Response:\
         Item with given Id is deleted Successfully !
             
-----
Order Api

1) Single Order:\

    Request:\ 
        url:\
         http://localhost:8080/order\
        type:<br>
         POST<br>
        request Header:<br>
         Content-Type:application/json<br>
        body:<br>
         {"customer":{"id":"1"},
          "itemOrdered": {"item":{"id":"1"},"quantity":"10"},
         "type":"SINGLE"
        }
         
    Response:<br>
        SUCCESS
    