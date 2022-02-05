function checkCartEmpty() {
  console.log("cart empty method called");
  const empty = !(document.getElementsByClassName("cardlist").length > 0);
  if (empty) {
    document.getElementsByClassName("btn-cart")[0].hidden = true;
    document.getElementsByClassName("btn-cart")[1].disabled = true;
  }
}