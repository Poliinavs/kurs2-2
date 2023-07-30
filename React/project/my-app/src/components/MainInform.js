import React from 'react';

import VisibleJobList from '../containers/VisibleJobList'
import Filter from '../components/Filter'

// import  '../style/MainInform.css'
// import  '../style/Filter.css'


// import fr from '../img/List/Fr.png'
// import like from '../img/List/like.png'

//Это похожн на TodoList 
//в этом файле отрисуем видимое меню и кнопку при нажатии на которую
//будет изменятьься видимость(вызывается генератор)
//и прокидывается открывающ меню с выпадающим списком и в параметр вилимость
//TodoList



const MainInform=() =>{
       



  return (



    <div className='MainInform'>
        <Filter/>

  <VisibleJobList />


    </div>
 


  );

};
export default MainInform;