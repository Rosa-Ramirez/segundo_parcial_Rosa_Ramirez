/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
function sendForm(){
	const XHR = new XMLHttpRequest();
	  var formData = new URLSearchParams(new FormData(document.getElementById('form'))).toString();
          
	  XHR.addEventListener('error', (event) => {
	    alert('Oops! Something went wrong.');
	  });

	  // Set up our request
	  XHR.open('POST', 'BookServlet', true);
                    XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    
                    XHR.onload = () => {
                        if (XHR.readyState === XHR.DONE && XHR.status === 200) {
                            console.log("response => " + XHR.response);
                            document.getElementById("bodyTable").innerHTML=XHR.response;
                            showMessage("Libro Registrado");
                            
                        }
                    };
                    
	  XHR.send(formData);
}

function deleteBook(code){
    const XHR = new XMLHttpRequest();
    var formData = new URLSearchParams(new FormData());

    // Define what happens in case of error
    XHR.addEventListener('error', (event) => {
      alert('Oops! Something went wrong.');
    });

    // Set up our request
    XHR.open('POST', 'BookServlet', true);
    XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    XHR.onload = () => {
      if (XHR.readyState === XHR.DONE && XHR.status === 200) {
        console.log("response => " + XHR.response);
        showMessage('Libro Eliminado Exitosamente');
        setTimeout( function() { window.location.reload(); }, 2000 );
      }
    };        
    formData.append('book_code', code);
    formData.append('control', 'DELETE');
    XHR.send(formData); 
    
}

function showMessage(message){
  Swal.fire({
  title: message,
  width: 600,
  padding: '3em',
  color: '#716add',
  background: '#fff url(Images/fondo.jpg)',
  backdrop: `
    rgba(0,0,123,0.4)
    url("Images/nyan-cat.gif")
    left top
    no-repeat
  `
});
}