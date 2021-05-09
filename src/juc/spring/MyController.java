package juc.spring;

//@Controller
public class MyController {


//    @Autowired
    private MyService myService;

    private  void   getPost(){
        myService.postImp();
    }

}
