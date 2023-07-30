// import React, { useState } from 'react';
// import PropTypes from 'prop-types';
// import Job from './Job';
// import Information from './Information';
// import '../style/MainInform.css';
// import '../style/Filter.css';
// import fr from '../img/List/Fr.png';
// import like from '../img/List/like.png';

// const JobList = (props) => {
//   const { jobs, jobTodo } = props;
//   const [selectedJobId, setSelectedJobId] = useState(1);

//   const handleJobClick = (id) => {
//     setSelectedJobId(id);
//     jobTodo(id);
//   };
  
//   const BlockClick = (id) => {
//     setSelectedJobId(id);
  
//   };

//   return (
//     <div>
//       <div className='Inf'>
//         <div className='SmallJobCont'>
//           {jobs.map((job) => (
//             <Job
//               key={job.id}
//               {...job}
//               onClick={() => handleJobClick(job.id)}
//               BlockClick={() => BlockClick(job.id)}
//             />
//           ))}
//         </div>
//         <Information id={selectedJobId} />
//       </div>
//     </div>
//   );
// };

// JobList.propTypes = {
//   jobs: PropTypes.array.isRequired,
//   jobTodo: PropTypes.func.isRequired,
// };

// export default JobList;
import React, { useState, useEffect } from 'react';
import PropTypes from 'prop-types';
import Job from './Job';
import Information from './Information';
import '../style/MainInform.css';
import '../style/Filter.css';
import fr from '../img/List/Fr.png';
import like from '../img/List/like.png';

export const initialSelectedJobId = 1;

export const BlockClick = (id, setSelectedJobId) => {
  setSelectedJobId(id);
};

const JobList = (props) => {
  const { jobs, jobTodo } = props;
  const [selectedJobId, setSelectedJobId] = useState(initialSelectedJobId);

  const handleJobClick = (id) => {
    setSelectedJobId(id);
    jobTodo(id);
  };

  useEffect(() => {
    if (jobs.length > 0) {
      setSelectedJobId(jobs[0].id); // Установка первого значения id в selectedJobId
    }
  }, [jobs]);

  const BlockClick = (id) => {
    setSelectedJobId(id);
  };

  return (
    <div>
      <div className='Inf'>
        <div className='SmallJobCont'>
          {jobs.map((job) => (
            <Job
              key={job.id}
              {...job}
              onClick={() => handleJobClick(job.id)}
              BlockClick={() => BlockClick(job.id)}
            />
          ))}
        </div>
        <Information id={selectedJobId} />
      </div>
    </div>
  );
};

JobList.propTypes = {
  jobs: PropTypes.array.isRequired,
  jobTodo: PropTypes.func.isRequired,
};

export default JobList;


