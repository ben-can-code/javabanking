const BASE = '/bank-api';

/* ── Auth ─────────────────────────────────────────────────────── */
function saveAuth(u, p) {
  sessionStorage.setItem('bu', u);
  sessionStorage.setItem('bc', btoa(u + ':' + p));
}
function getAuth()     { return sessionStorage.getItem('bc'); }
function getUsername() { return sessionStorage.getItem('bu') || ''; }
function getUserInfo() { try { return JSON.parse(sessionStorage.getItem('binfo') || '{}'); } catch(e) { return {}; } }
function isLoggedIn()  { return !!getAuth(); }

function logout() { sessionStorage.clear(); window.location.href = 'index.html'; }
function requireAuth() { if (!isLoggedIn()) window.location.href = 'index.html'; }
function redirectIfLoggedIn() { if (isLoggedIn()) window.location.href = 'dashboard.html'; }

/* ── Fetch wrapper ────────────────────────────────────────────── */
async function apiFetch(path, opts = {}) {
  const headers = {
    'Content-Type': 'application/json',
    'Authorization': 'Basic ' + getAuth(),
    ...(opts.headers || {})
  };
  const res = await fetch(BASE + path, { ...opts, headers });
  if (res.status === 401) { logout(); return null; }
  return res;
}

/* ── Toast ────────────────────────────────────────────────────── */
function showToast(msg, type = 'info') {
  const icons = { success:'✅', error:'❌', info:'ℹ️' };
  const c = document.getElementById('toast-container');
  if (!c) return;
  const t = document.createElement('div');
  t.className = `toast toast-${type}`;
  t.innerHTML = `<span>${icons[type]||'ℹ️'}</span><span>${msg}</span>`;
  c.appendChild(t);
  setTimeout(() => { t.style.cssText='opacity:0;transition:opacity .4s'; setTimeout(()=>t.remove(),400); }, 3400);
}

/* ── Modal ────────────────────────────────────────────────────── */
function openModal(id)  { document.getElementById(id)?.classList.add('show'); }
function closeModal(id) { document.getElementById(id)?.classList.remove('show'); }

/* ── Section switching ────────────────────────────────────────── */
function showSection(name) {
  document.querySelectorAll('.section').forEach(s => s.classList.remove('active'));
  document.querySelectorAll('.nav-item').forEach(n => n.classList.remove('active'));
  document.getElementById('section-' + name)?.classList.add('active');
  document.querySelector(`[data-section="${name}"]`)?.classList.add('active');
  const T = {
    overview:     ['Overview',      'Welcome back! Here\'s your summary.'],
    myaccount:    ['My Account',    'Your profile and linked account.'],
    customers:    ['Customers',     'Manage all customer profiles.'],
    accounts:     ['Accounts',      'View and manage bank accounts.'],
    transfer:     ['Transfer',      'Move funds between accounts.'],
    transactions: ['Transactions',  'Browse transaction history.'],
  };
  if (T[name]) {
    const el = document.getElementById('topbar-title');
    const es = document.getElementById('topbar-sub');
    if (el) el.textContent = T[name][0];
    if (es) es.textContent = T[name][1];
  }
  if (name === 'overview')   loadOverview();
  if (name === 'customers')  loadCustomers();
  if (name === 'myaccount')  loadMyAccount();
}

/* ── Formatters ───────────────────────────────────────────────── */
function fmtMoney(v)    { return '$' + Number(v||0).toLocaleString('en-US',{minimumFractionDigits:2}); }
function fmtDate(d)     { return d ? new Date(d).toLocaleDateString() : '—'; }
function initials(f,l)  { return ((f||'?')[0]+(l||'?')[0]).toUpperCase(); }
