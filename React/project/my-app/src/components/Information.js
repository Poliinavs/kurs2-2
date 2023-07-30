
import React from 'react'
import PropTypes from 'prop-types'
import  '../style/MainInform.css'
import  '../style/Job.css'

import  '../style/Informprod.css'
 
// const images = [
//     require('../img/List/React.png'),
//     require('../img/List/Fr.png'),
//     require('../img/List/Three.png'),
//     require('../img/List/Foth.png')
//   ];

const inf = [
    {
      path: require('../img/List/React.png'),
      company: 'Front-end Разработчиĸ',
      name: 'Winfinity | Москва',
      price: 'От 150 000 до 300 000 руб.',
      info: 'Дополнительная информация о вакансии 1'
    },
    {
      path: require('../img/List/Fr.png'),
      company: 'React Developer (Middle/Senior)',
      name: 'Senior | Минск',
      price: 'От 120 000 до 200 000 руб.',
      info: 'Дополнительная информация о вакансии 2'
    },
    {
      path: require('../img/List/Three.png'),
      company: 'Frontend developer (React)',
      name: 'Winfinity | США',
      price: 'От 4 000 до 10 000 руб.',
      info: 'Дополнительная информация о вакансии 3'
    },
    {
      path: require('../img/List/Foth.png'),
      company: 'Frontend developer',
      name: 'Winfinity | Италия',
      price: 'От 10 000 до 200 000 руб.',
      info: 'Дополнительная информация о вакансии '
    }
  ];

//Стиль для 1 жлемента из MainInform в отдельный


const Information = ({id} ) => {

 
  
    return (
        <div className='Informprod'>
            <div className='container'>
                <div className='frstRow'> 
                    <img class="image" src={inf[id-1].path} alt="Картинка" />
          
                    <div className='FrCol'>
                        <p className='NameComp1'>{inf[id-1].company}</p>
                        <p className='SmallText1'>{inf[id-1].name}</p>
                    </div>
                            
                </div>
             <p className='NameComp1'>{inf[id-1].price}</p>

<div className='Inform'>
    <p>
    Мы, Winfinity, занимаемся разработкой инновационных решений в области игорно-развлекательного контента.

    </p>
    <p>
    Для создания наших продуктов используются передовые технологии, среди которых: Computer Vision, Unreal Engine, Ultra Low Latency Video Streaming. У нас очень крутой и суперсовременный технопарк - от камер и света, до графических карт, которые почти невозможно найти.
     </p>
<p>
Сегодня мы на стадии активного развития. Мы создаём масштабный, технологически сложный и в тоже время очень интересный, глобальный проект - частью которого можете стать Вы!

</p>

</div>

            </div>
             
        </div>
);
};



export default Information
