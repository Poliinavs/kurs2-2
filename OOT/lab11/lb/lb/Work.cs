using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lb
{
  /*  public interface IRepository<UserAuth>
    {
        IEnumerable<UserAuth> GetAll();
        UserAuth GetById(int id);
        void Add(UserAuth entity);
        void Update(UserAuth entity);
        IEnumerable<UserAuth> Sort();
        List<UserAuth> Delete(List<UserAuth> entity);
    }

    public class Repository<T> : IRepository<UserAuth> where T : class
    {
        private readonly DbContext _context;
        private readonly DbSet<UserAuth> dbSet = OOTEntities.GetContext().UserAuth;
        private readonly DbSet<UserAuth> _dbSet;

        public Repository(DbContext context)
        {
            // _context = context;
            _context = OOTEntities.GetContext();
            _dbSet = context.Set<UserAuth>();

        }

        public IEnumerable<UserAuth> GetAll()
        {
            return _dbSet.ToList();
        }

        public UserAuth GetById(int id)
        {
            return dbSet.Find(id);
        }

        public void Add(UserAuth entity)
        {
            dbSet.Add(entity);
            _context.SaveChanges();
        }

        public void Update(UserAuth entity)
        {
            _context.Entry(entity).State = EntityState.Modified;
            _context.SaveChanges();
        }
        public IEnumerable<UserAuth> Sort()
        {
            var obj = dbSet.ToList();


            var sortedPeople1 = from p in obj
                                orderby p.name
                                select p;
            _context.SaveChanges();
            return sortedPeople1;
        }
        public List<UserAuth> Delete(List<UserAuth> UserRemove)
        {

            dbSet.RemoveRange(UserRemove);
            _context.SaveChanges();
            return dbSet.ToList();


        }
        public List<UserAuth> Del(UserAuth UserRemove)
        {

            dbSet.Remove(UserRemove);
            _context.SaveChanges();
            return dbSet.ToList();
        }

    }*/
}
