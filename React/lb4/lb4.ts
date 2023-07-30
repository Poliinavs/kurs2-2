//1
type Student = {
  id: number,
  name: string,
  group: number
}

const array: Student[] = [
  {id: 1, name: 'Vasya', group: 10}, 
  {id: 2, name: 'Ivan', group: 11},
  {id: 3, name: 'Masha', group: 12},
  {id: 4, name: 'Petya', group: 10},
  {id: 5, name: 'Kira', group: 11},
]
//2
type CarsType =
{
    manufacturer?: string;
    model?: string;
}

let car: CarsType = {}; //объект создан!
car.manufacturer = "manufacturer";
car.model = 'model';
//3
const car1: CarsType = {}; //объект создан!
car1.manufacturer = "manufacturer";
car1.model = 'model';

const car2: CarsType = {}; //объект создан!
car2.manufacturer = "manufacturer";
car2.model = 'model';

type ArrayCars = {
    cars: CarsType[];
}

const arrayCars: Array<ArrayCars> = [{
    cars: [car1, car2]
}];
//4
type DoneType = boolean;
type MarkFilterType = 1|2|3|4|5|6|7|8|9|10;
type GroupFilterType = MarkFilterType|11|12;

type MarkType = {
    subject: string,
    mark: MarkFilterType, // может принимать значения от 1 до 10
    done: DoneType,
}
 
type StudentType = {
    id: number,
    name: string,
    group: GroupFilterType, // может принимать значения от 1 до 12
    marks: Array<MarkType>
}

type GroupType = {
  students: Array<StudentType>, // массив студентов типа StudentType
  studentsFilter: (group: GroupFilterType) => Array<StudentType>, // фильтр по группе
  marksFilter: (mark: MarkFilterType) => Array<StudentType>, // фильтр по  оценке
  deleteStudent: (id: number) => void, // удалить студента по id из  исходного массива
  mark: MarkFilterType,
  group: GroupFilterType,
}

let mark2: MarkType = {
  subject: "Math",
  mark: 8,
  done: true
}
let mark1: MarkType = {
  subject: "Math",
  mark: 6,
  done: true
}
let mark3: MarkType = {
  subject: "Math",
  mark: 6,
  done: true
}
let student1: StudentType = {
  id: 1,
  name: "Lev",
  group: 1,
  marks: [ mark1, mark2 ]
}
let student2: StudentType = {
  id: 2,
  name: "Lev",
  group: 3,
  marks: [ mark1, mark3 ]
}

const group: GroupType = {

  students: [student2, student1],

  studentsFilter(group: GroupFilterType): Array<StudentType> 
  {
      var Students: Array<StudentType> = [];

      for (let student of this.students) 
      {
          if (student.group == group) 
          {
           Students.push(student);
          }
      }
      return Students;
 },

  marksFilter(mark: MarkFilterType): Array<StudentType> 
  {
      var Students: Array<StudentType> = [];
 var average =0;
 var k =0;
      for (let student of this.students) 
      {
        for (let mk of student.marks){
          average+=mk.mark;
          k++;
        }
        average=average/k;
        if (average >= mark) 
        {
         Students.push(student);
        }
        average=0;
      }
      return Students;
  },
  deleteStudent(id: number): void 
  {
    
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
