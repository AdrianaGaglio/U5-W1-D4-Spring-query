//package epicode.it.pizzeria.runner;
//
//import epicode.it.pizzeria.entity.order.Status;
//import epicode.it.pizzeria.entity.order.OrderRepo;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Scanner;
//
//@Component
//@Order(8)
//@RequiredArgsConstructor
//public class HandleOrders implements ApplicationRunner {
//    private final OrderRepo orderRepo;
//
//    @Override
//    @Transactional
//    public void run(ApplicationArguments args) throws Exception {
//        Scanner scanner = new Scanner(System.in);
//        try {
//            while (true) {
//                List<epicode.it.pizzeria.entity.order.Order> orders = orderRepo.findAll();
//                System.out.println("List of orders:");
//                orders.forEach(System.out::println);
//                System.out.println("Select order to manage:");
//                long opt = scanner.nextLong();
//                scanner.nextLine();
//                if(opt == 0) return;
//                if (opt <= orders.size()) {
//                    epicode.it.pizzeria.entity.order.Order selectedOrder = orderRepo.findById(opt).orElse(null);
//                    boolean valid = false;
//                    while (!valid) {
//                        System.out.println("Select new order status: 1-IN_PREPARATION 2-DELIVERED");
//                        int status = scanner.nextInt();
//                        scanner.nextLine();
//                        switch (status) {
//                            case 1 -> {
//                                selectedOrder.setStatus(Status.IN_PREPARATION);
//                                orderRepo.save(selectedOrder);
//                                valid = true;
//                            }
//                            case 2 -> {
//                                selectedOrder.setStatus(Status.DELIVERED);
//                                orderRepo.save(selectedOrder);
//                                valid = true;
//                            }
//                            default -> {
//                                System.out.println("Selection is not valid, retry");
//                            }
//                        }
//                    }
//                } else if(opt > orders.size()){
//                    System.out.println("Invalid selection, retry");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            scanner.close();
//        }
//    }
//}
