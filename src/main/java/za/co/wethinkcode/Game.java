package za.co.wethinkcode;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.beans.Visibility;
//
//public class Game{
//    ChoiceHandler cHandler = new ChoiceHandler();
//    UI ui = new UI();
//    VisibilityManager vm = new VisibilityManager(ui);
//     Story story= new Story(this, ui, vm);
//
//    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
//
//    public static void main(String[] args) {
//        new Game();
//    }
//
//    public Game()
//    {
//        ui.createUI(cHandler);
//        vm.showTitleScreen();
//      /*   story.defaultSetup();
//        */
//    }
//
//    public class ChoiceHandler implements ActionListener{
//        public void actionPerformed(ActionEvent event){
//            String yourChoice = event.getActionCommand();
//
//            switch(yourChoice){
//                case "start" : /* vm.titleToTown(); story.townGate(); */ break;
//                case "c1" :/*  story.selectPositioin(nextPosition1) */;break;
//                case "c2" : /* story.selectPositioin(nextPosition2) */;break;
//                case "c3" : /* story.selectPositioin(nextPosition3) */;break;
//                case "c4" : /* story.selectPositioin(nextPosition4) */;break;
//            }
//        }
//    }
//}