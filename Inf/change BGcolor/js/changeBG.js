color = ["#ec0000", "#02b700", "#0000b3"];
i = 0;

document.getElementById("submit").onclick = function(){
  document.body.style.backgroundColor = color[i];
  i++;
  if( i >= color.length) {
      i = 0;
  }
}
