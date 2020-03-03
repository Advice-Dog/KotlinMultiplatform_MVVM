import UIKit
import SharedCode
import Firebase

struct Article{
    let name: String!
    let text: String!
}

class TableViewController: UITableViewController {
    
    var list = [Article]()
    
    @IBOutlet var mTableView: UITableView!
    
    
    override func viewDidLoad() {
        
    }
    
    override func viewDidAppear(_ animated: Bool) {
        let db = Firestore.firestore()
        
        view.backgroundColor = #colorLiteral(red: 0.1802030457, green: 0.1802030457, blue: 0.1802030457, alpha: 1)
        self.navigationItem.title = "Home"
        
        db.collection("conferences").document("DEFCON27").collection("articles").getDocuments() { (querySnapshot, err) in
            if let err = err {
                print("Error getting documents: \(err)")
            } else {
                let articles = querySnapshot!.documents.map { Article(name: $0.data()["name"] as! String, text: $0.data()["text"] as! String)}
                
                self.list = articles
                self.tableView?.reloadData()
            }
        }
    }
    
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return list.count + 1
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        if indexPath.row == 0 {
            return Bundle.main.loadNibNamed("SkullHeaderTableViewCell", owner: self, options: nil)?.first as! SkullHeaderTableViewCell
        }
        
        let cell = Bundle.main.loadNibNamed("ArticleTableViewCell", owner: self, options: nil)?.first as! ArticleTableViewCell
            
        cell.mName.text = list[indexPath.row - 1].name
        cell.mText.text = list[indexPath.row - 1].text
        
        return cell
    }
}


