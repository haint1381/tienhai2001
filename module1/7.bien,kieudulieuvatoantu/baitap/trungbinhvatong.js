let inputPhysical;
let inputChemistry;
let inputBiological;
inputphysical = prompt("nhập điểm môm vật lý");
inputchemistry = prompt("nhập điểm môm hóa học");
inputbiological = prompt("nhập điểm môm sinh học");
let physical = parseInt(inputphysical);
let chemistry = parseInt(inputchemistry);
let biological = parseInt(inputbiological);
let area = (physical+chemistry+biological)/3;
document.write("Điểm Trung Bình:" +area);
let area1 = (physical+chemistry+biological);
document.write("Tổng Điểm Các Môn:" +area1);