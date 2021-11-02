var color = ["#ec0000", "#02b700", "#0000b3"];
var i = 0;

document.querySelector("#submit").onclick = function(){
  document.body.style.backgroundColor = color[i];
  i++;
  if( i >= color.length) {
      i = 0;
  }
}
