using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace lb8
{
    public class UserInformRepository
    {
        private DbContext _context;
        private readonly DbSet<UserInform> dbSet = OOTEntities.GetContext().UserInform;
 
        public UserInformRepository()
        {
            _context = OOTEntities.GetContext();
        }

        public void AddCustomer(UserInform customer)
        {

            dbSet.Add(customer);
            _context.SaveChanges();
        }

    

    }
    public class UserInformUnitOfWorkFactory
    {
        public static DbContext _context;
        public static readonly DbSet<UserInform> dbSet = OOTEntities.GetContext().UserInform;


        public UserInformUnitOfWorkFactory()
        {
            _context = OOTEntities.GetContext();
        }

        public UserInformUnitOfWorkFactory CreateUnitOfWork()
        {
            return new UserInformUnitOfWorkFactory();
        }
    }

    public class UserInformUnitOfWork : IDisposable
    {
      /*  private DbContext _context;
        private readonly DbSet<UserInform> dbSet = OOTEntities.GetContext().UserInform;*/
        private UserInformRepository _repository;
        private DbContextTransaction _transaction;

        public UserInformUnitOfWork()
        {
            UserInformUnitOfWorkFactory._context = OOTEntities.GetContext();
            _repository = new UserInformRepository();
            _transaction = UserInformUnitOfWorkFactory._context.Database.BeginTransaction();
        }

        public UserInformRepository CustomersRepository
        {
            get { return _repository; }
        }

        public void SaveChanges()
        {
            UserInformUnitOfWorkFactory._context.SaveChanges();
            _transaction.Commit();
        }

        public void Dispose()
        {
            _transaction.Dispose();
            UserInformUnitOfWorkFactory._context.Dispose();
        }
    }

}
