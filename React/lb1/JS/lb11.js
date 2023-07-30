//задание 1
var numb = new Array(3, 9, 3, 9, 9, 9, 1, 2, 3, 6);
function disp(arr_numbers) {
    let str = "(";
    for (var i = 0; i < arr_numbers.length; i++) {
        str += arr_numbers[i];
        if (i == 2)
            str += ") ";
        if (i == 5)
            str += "-";
    }
    return str;
}
console.log(disp(numb));
//задание 2
let value = prompt('второе  задание, введите число');
function find_multiples(value) {
    var sum = 0;
    if (value == 0)
        return sum;
    for (var i = 0; i < value; i++) {
        if (i % 3 == 0)
            sum += i;
        if (i % 5 == 0)
            sum += i;
    }
    return sum;
}
console.log(find_multiples(+value));
console.log("----------------------------");
//задание 3
var value3 = prompt('третье задание, введите число');
var nums = [1, 2, 3, 4, 5, 6, 7];
for (var i = 0; i < +value3; i++) {
    nums.unshift(nums.at(-1));
    nums.pop();
}
for (var j in nums) {
    console.log(nums[j]);
}
console.log("----------------------------");
//задание 4
var nums1 = [1, 3];
var nums2 = [2, 4];
var nums3 = nums1.concat(nums2);
nums3.sort();
var median = 0;
var a = nums3.length / 2;
if (nums3.length % 2 == 0) {
    median = (nums3[a] + nums3[a - 1]) / 2;
}
else
    median = nums3[a - 0.5];
console.log(median);
console.log("----------------------------");
//задание 5
var sudoku = [[6, 3, 8, 4, 2, 7, 9, 1, 5],
    [5, 9, 1, 8, 6, 3, 4, 2, 7],
    [4, 2, 7, 9, 1, 5, 8, 6, 3],
    [9, 1, 5, 6, 3, 8, 7, 4, 2],
    [7, 4, 2, 1, 5, 9, 6, 3, 8],
    [3, 8, 6, 7, 4, 2, 1, 5, 9],
    [2, 7, 4, 5, 9, 1, 3, 8, 6],
    [8, 6, 3, 2, 7, 4, 5, 9, 1],
    [1, 5, 9, 3, 8, 6, 2, 7, 4]
];
var fail = false;
let check = new Set();
let check_kvadr1 = new Set();
let check_kvadr2 = new Set();
let check_kvadr3 = new Set();
for (var i = 0; i < 9 && !fail; ++i) {
    if (i == 3 || i == 6) {
        check_kvadr1.clear();
        check_kvadr2.clear();
        check_kvadr3.clear();
    }
    for (var k = 0; k < 9 && !fail; ++k) {
        if (k >= 0 && k < 3) {
            if (check_kvadr1.has(sudoku[i][k]))
                fail = true;
            else
                check_kvadr1.add(sudoku[i][k]);
        }
        if (k >= 3 && k < 6) {
            if (check_kvadr2.has(sudoku[i][k]))
                fail = true;
            else
                check_kvadr2.add(sudoku[i][k]);
        }
        if (k >= 6 && k < 9) {
            if (check_kvadr3.has(sudoku[i][k]))
                fail = true;
            else
                check_kvadr3.add(sudoku[i][k]);
        }
        if (check.has(sudoku[i][k]))
            fail = true;
        else
            check.add(sudoku[i][k]);
    }
    check.clear();
}
for (i = 0; i < 9 && !fail; ++i) {
    for (var k = 0; k < 9 && !fail; ++k) {
        if (check.has(sudoku[k][i]))
            fail = true;
        else
            check.add(sudoku[k][i]);
    }
    check.clear();
}
if (fail)
    console.log("Ошибка");
if (!fail)
    console.log("Все верно");
