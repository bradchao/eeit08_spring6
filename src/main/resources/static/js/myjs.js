window.onload = function(){
	let start = document.getElementById("start");
	let chatDiv = document.getElementById("chatDiv");
	let mesg = document.getElementById("mesg");
	let send = document.getElementById("send");
	let log = document.getElementById("log");
	
	start.style.display = "block";
	chatDiv.style.display = "none";
	
	let webSocket;
	
	start.addEventListener("click",function(){
		connect("ws://10.0.101.65:8080/BradWeb/myserver");
	});
	send.addEventListener("click", function(){
		let message = {
			message: mesg.value
		};
		webSocket.send(JSON.stringify(message));
	});
	
	function connect(url){
		webSocket = new WebSocket(url);
		
		webSocket.onopen = function(){
			console.log("onopen");
			start.style.display = "none";
			chatDiv.style.display = "block";
		};
		
		webSocket.onmessage = function(event){
			let mesgObj = JSON.parse(event.data);
			log.innerHTML += mesgObj.message + "<br />";
		};
		webSocket.onclose = function(){
			console.log("onclose");
		};
		webSocket.onerror = function(event){
			console.log("onerror:" + event.data);
		};
	}
	
	
	
}
