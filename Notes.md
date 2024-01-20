If we take just String (VehicalNumber) as input to generate a ticket ,then in future if we want to add new param for generating ticket,then we will have multiple variant of the gererateTicket > TicketController Simple way to solve this by DTO 

RequestDTO will have all the thighs neccessary for getting the request from the client ResponseDTOs will have all things that will be sent to the client,
We can protect attribute like password using this.