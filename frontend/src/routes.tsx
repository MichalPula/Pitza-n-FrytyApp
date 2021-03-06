import About from "./pages/About"
import Account from "./pages/Account"
import Contact from "./pages/Contact";
import LandingPage from "./pages/LandingPage";

const routes = [
  {
    path: "/contact",
    component: Contact,
    btnText: "kontakt",
  },
  {
    path: "/about",
    component: About,
    btnText: "o nas",
  },
  {
    path: "/",
    exact: true,
    component: LandingPage,
  },
  {
    path: "/account",
    component: Account,
    btnText: "konto",
  },
]

export default routes
