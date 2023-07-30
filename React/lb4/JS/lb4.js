const array = [
    { id: 1, name: 'Vasya', group: 10 },
    { id: 2, name: 'Ivan', group: 11 },
    { id: 3, name: 'Masha', group: 12 },
    { id: 4, name: 'Petya', group: 10 },
    { id: 5, name: 'Kira', group: 11 },
];
let car = {}; //объект создан!
car.manufacturer = "manufacturer";
car.model = 'model';
//3
const car1 = {}; //объект создан!
car1.manufacturer = "manufacturer";
car1.model = 'model';
const car2 = {}; //объект создан!
car2.manufacturer = "manufacturer";
car2.model = 'model';
const arrayCars = [{
        cars: [car1, car2]
    }];
let mark2 = {
    subject: "Math",
    mark: 8,
    done: true
};
let mark1 = {
    subject: "Math",
    mark: 6,
    done: true
};
let mark3 = {
    subject: "Math",
    mark: 6,
    done: true
};
let student1 = {
    id: 1,
    name: "Lev",
    group: 1,
    marks: [mark1, mark2]
};
let student2 = {
    id: 2,
    name: "Lev",
    group: 3,
    marks: [mark1, mark3]
};
const group = {
    students: [student2, student1],
    studentsFilter(group) {
        var Students = [];
        for (let student of this.students) {
            if (student.group == group) {
                Students.push(student);
            }
        }
        return Students;
    },
    marksFilter(mark) {
        var Students = [];
        var average = 0;
        var k = 0;
        for (let student of this.students) {
            for (let mk of student.marks) {
                average += mk.mark;
                k++;
            }
            average = average / k;
            if (average >= mark) {
                Students.push(student);
            }
            average = 0;
        }
        return Students;
    },
    deleteStudent(id) {
        this.students = this.students.filter((student) => student.id !== id);
    },
    mark: 10,
    group: 5,
};
console.log(group.marksFilter(6));
console.log(group.studentsFilter(1));
console.log(group.students.length);
group.deleteStudent(2);
console.log(group.students.length);
