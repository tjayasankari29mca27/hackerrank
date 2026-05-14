#include <iostream>
#include <vector>
#include <map>
#include <string>
#include <algorithm>
#include <set>
#include <cassert>
using namespace std;

struct Node{
   Node* next;
   Node* prev;
   int value;
   int key;
   Node(Node* p, Node* n, int k, int val):prev(p),next(n),key(k),value(val){};
   Node(int k, int val):prev(NULL),next(NULL),key(k),value(val){};
};

class Cache{
   
   protected: 
   map<int,Node*> mp; //map the key to the node in the linked list
   int cp;  //capacity
   Node* tail; // double linked list tail pointer
   Node* head; // double linked list head pointer
   virtual void set(int, int) = 0; //set function
   virtual int get(int) = 0; //get function

};
class LRUCache : public Cache {
public:
    // Constructor to initialize capacity and boundary pointers
    LRUCache(int capacity) {
        cp = capacity;
        head = NULL;
        tail = NULL;
    }

    // Helper function to remove an existing node from the DLL
    void removeNode(Node* node) {
        if (!node) return;
        
        if (node->prev) {
            node->prev->next = node->next;
        } else {
            head = node->next; // Node was the head
        }
        
        if (node->next) {
            node->next->prev = node->prev;
        } else {
            tail = node->prev; // Node was the tail
        }
    }

    // Helper function to insert a node at the head (Most Recently Used position)
    void insertAtHead(Node* node) {
        node->next = head;
        node->prev = NULL;
        
        if (head) {
            head->prev = node;
        }
        head = node;
        
        if (!tail) {
            tail = head;
        }
    }

    // Retrieve value from cache and move the node to the head position
    int get(int key) override {
        if (mp.find(key) == mp.end()) {
            return -1;
        }
        
        Node* node = mp[key];
        removeNode(node);
        insertAtHead(node);
        return node->value;
    }

    // Insert or update a key-value pair in the cache
    void set(int key, int value) override {
        if (cp <= 0) return;

        // Case 1: Key already exists, update value and make it most recent
        if (mp.find(key) != mp.end()) {
            Node* node = mp[key];
            node->value = value;
            removeNode(node);
            insertAtHead(node);
            return;
        }

        // Case 2: Cache is full, evict the Least Recently Used (tail) node
        if (mp.size() >= (size_t)cp) {
            Node* lruNode = tail;
            mp.erase(lruNode->key);
            removeNode(lruNode);
            delete lruNode;
        }

        // Case 3: Insert new node at the head position
        Node* newNode = new Node(key, value);
        insertAtHead(newNode);
        mp[key] = newNode;
    }

    // Destructor to free allocated memory
    ~LRUCache() {
        Node* current = head;
        while (current) {
            Node* nextNode = current->next;
            delete current;
            current = nextNode;
        }
    }
};

int main() {
   int n, capacity,i;
   cin >> n >> capacity;
   LRUCache l(capacity);
   for(i=0;i<n;i++) {
      string command;
      cin >> command;
      if(command == "get") {
         int key;
         cin >> key;
         cout << l.get(key) << endl;
      } 
      else if(command == "set") {
         int key, value;
         cin >> key >> value;
         l.set(key,value);
      }
   }
   return 0;
}
