using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace lb8
{
    public class SQLUserRepository 
    {
        private MainWindow db;
        private static OOTEntities context;
       /* public SQLUserRepository()
        {
            this.db = new BookContext();
        }*/
        public static OOTEntities GetContext()
        {
            if (context == null)
            {
                context = new OOTEntities();
            }
            return context;
        }
      /*  public static void Del()
        {
            var UserRemove = db.DGridAuth.SelectedItems.Cast<UserAuth>().ToList();
            OOTEntities.GetContext().UserAuth.RemoveRange(UserRemove);
            OOTEntities.GetContext().SaveChanges();
            MessageBox.Show("Данные удалены");
            DGridAuth.ItemsSource = OOTEntities.GetContext().UserAuth.ToList();
        }*/

        /*  public IEnumerable<Book> GetBookList()
          {
              return db.Books;
          }

          public Book GetBook(int id)
          {
              return db.Books.Find(id);
          }

          public void Create(Book book)
          {
              db.Books.Add(book);
          }

          public void Update(Book book)
          {
              db.Entry(book).State = EntityState.Modified;
          }

          public void Delete(int id)
          {
              Book book = db.Books.Find(id);
              if (book != null)
                  db.Books.Remove(book);
          }

          public void Save()
          {
              db.SaveChanges();
          }
  */
       /* private bool disposed = false;

        public virtual void Dispose(bool disposing)
        {
            if (!this.disposed)
            {
                if (disposing)
                {
                    db.Dispose();
                }
            }
            this.disposed = true;
        }
*/
     /*   public void Dispose()
        {
            Dispose(true);
            GC.SuppressFinalize(this);
        }
*/
        public IEnumerable<UserAuth> GeUserList()
        {
            throw new NotImplementedException();
        }

        public UserAuth GetUser(int id)
        {
            throw new NotImplementedException();
        }

        public void Create(UserAuth item)
        {
            throw new NotImplementedException();
        }

        public void Update(UserAuth item)
        {
            throw new NotImplementedException();
        }
    }
}
