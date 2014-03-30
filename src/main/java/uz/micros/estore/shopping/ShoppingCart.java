package uz.micros.estore.shopping;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope("session")
public class ShoppingCart implements Serializable {
}
